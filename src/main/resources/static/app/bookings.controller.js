/**
 * Created by hong on 2017-07-09.
 */
(function() {
    'use strict';

    angular.module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http', '$scope'];

    function BookingsController($http, $scope) {
        var vm = this;

        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;

        init();

        function init() {
            getAll();
        }

        $scope.test = function() {
            $scope.first = ["전체", "여성패션", "남성·유니섹스패션", "여성브랜드패션", "남성브랜드패션", "스포츠패션", "뷰티", "식품·건강", "출산·유아동", "생활·주방", "가구·홈·데코", "반려동물", "가전·디지털", "레포츠·자동차", "도서·교육·문구·취미·E쿠폰", "국내·제주·숙박·입장권", "해외여행·입장권·패스", "공연·전시·체험·게임", "지역할인쿠폰", "슈퍼마트", "웨어웨어", "여행홈(모바일에만 사용)", "티몬직구", "롯데백화점", "[비즈몰]공통상품", "[비즈몰]업종별상품", "[비즈몰]업무지원", "실시간항공·호텔", "[비즈몰]회식", "[비즈몰]워크샵", "[비즈몰]뷰티·웨어"];
            $scope.second = {"전체" : ["전체"]};
            $scope.third = ["1", "이", "삼"];

            var go = true;
            angular.forEach($scope.first, function(data) {
                if (go) {
                    if (data === "스포츠패션") {
                        go = false;


                    }
                    $scope.second[data] = $scope.third;
                }


            });

            console.log($scope.second);
        };

        function getAll() {
            var url = "/bookings/all";
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response) {
                vm.bookings = response.data;
            });
        }

        function getAffordable() {
            var url = "/bookings/affordable/" + 100;
            var bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response) {
                vm.bookings = response.data;
            });
        }

        function deleteBooking(id) {
            var url = "/bookings/delete/" + id;
            $http.post(url).then(function(response) {
                vm.bookings = response.data;
            });
        }
    }
})();
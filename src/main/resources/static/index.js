angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    };


    $scope.changeCost = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    /*
        $scope.addProduct = function () {
            var pId = document.getElementById("newId").value;
            var pTitle = document.getElementById("newTitle").value;
            var pUnit = document.getElementById("newUnit").value;
            var pCost = document.getElementById("newCost").value;

            $http.get({
                url:contextPath + '/products/add',
                method: 'GET',
                params: {
                    productId: pId,
                    productTitle: pTitle,
                    productUnit: pUnit,
                    productCost: pCost
                }
            }).then(function (response) {
                    $scope.loadProducts();
            });
        };

    */
/*
    const form = document.getElementById('form');
    form.addEventListener('submit', getFormValue);
    function getFormValue(event) {
        event.preventDefault();
        const
            pId = form.querySelector('[name="newId"]'), //получаем поле name
            pTitle = form.querySelector('[name="newTitle"]'), //получаем поле age
            pUnit = form.querySelector('[name="newUnit"]'), //получаем поле terms
            pCost = form.querySelector('[name="newCost"]'); //получаем поле plan
*/

  /*      const data = {
            name: name.value,
            age: age.value,
            plan: plan.value,
            terms: terms.checked
            };*/
/*
        $http.get({
            url:contextPath + '/products/add',
            method: 'GET',
            params: {
                productId: pId,
                productTitle: pTitle,
                productUnit: pUnit,
                productCost: pCost
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }
*/

    $scope.loadProducts();
});

import angular from 'angular'

const app = angular.module('app', []);

const base = 'http://localhost:8080/'

app.controller('main', mainController)

function mainController() {
  const vm = this

  vm.usuario = null

  vm.login = name => {
    vm.usuario = {
    }
  }

  vm.logout = () => {
    vm.usuario = null
  }

  return vm
}

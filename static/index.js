import angular from 'angular'

const app = angular.module('app', []);

const base = 'http://localhost:8080'

app.controller('main', mainController)

function mainController($interval, $http) {
  const vm = this

  vm.usuario = null
  vm.data = new Date()

  vm.login = name => {
    $http.post(`${base}/usuario/login`, {
      login: name
    }).then(res => res.data)
      .then(usuario => vm.usuario = adjustDates(usuario))
  }

  vm.logout = () => {
    vm.usuario = null
  }

  vm.ponto = () => {
    const pontoPromise = $http.post(`${base}/usuario/${vm.usuario.id}/ponto`)
    pontoPromise.then(() =>
      $http.get(`${base}/usuario/${vm.usuario.id}`)
        .then(res => res.data)
        .then(usuario => vm.usuario = adjustDates(usuario))
    )
  }

  $interval(() => vm.data = new Date(), 500)

  vm.login('acesar')

  return vm
}

function adjustDates(usuario) {
  usuario.pontos = usuario.pontos.map(ponto => {
    ponto.entrada = new Date(ponto.entrada)
    if (ponto.saida !== null)
      ponto.saida = new Date(ponto.saida)
    return ponto
  }).reverse()
  return usuario
}

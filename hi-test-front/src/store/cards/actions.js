import { environment } from 'boot/axios'
import { Loading } from 'quasar'

function getCards ({ commit }) {
  Loading.show({
    delay: 400 // ms
  })
  return new Promise((resolve, reject) => {
    environment.get('/status/list')
      .then((success) => {
        commit('GET_CARDS', success.data)
        resolve(success.data)
        Loading.hide()
      })
      .catch((error) => {
        reject(error)
        Loading.hide()
      })
  })
}

const blockCards = ({ commit }, card) => {
  Loading.show({
    delay: 400 // ms
  })
  return new Promise((resolve, reject) => {
    const status = 0
    environment.post('/status/change/' + status, card)
      .then((success) => {
        resolve(success.data)
        commit('EDIT_CARDS', success.data)
        location.reload()
        Loading.hide()
      })
      .catch((error) => {
        reject(error)
        Loading.hide()
      })
  })
}

const activeCards = ({ commit }, card) => {
  Loading.show({
    delay: 400 // ms
  })
  return new Promise((resolve, reject) => {
    const status = 1
    environment.post('/status/change/' + status, card)
      .then((success) => {
        resolve(success.data)
        commit('EDIT_CARDS', success.data)
        location.reload()
        Loading.hide()
      })
      .catch((error) => {
        reject(error)
        Loading.hide()
      })
  })
}

const approvedCards = ({ commit }, card) => {
  Loading.show({
    delay: 400 // ms
  })
  return new Promise((resolve, reject) => {
    const status = 2
    environment.post('/status/change/' + status, card)
      .then((success) => {
        resolve(success.data)
        commit('EDIT_CARDS', success.data)
        location.reload()
        Loading.hide()
      })
      .catch((error) => {
        reject(error)
        Loading.hide()
      })
  })
}

const disapprovedCards = ({ commit }, card) => {
  Loading.show({
    delay: 400 // ms
  })
  return new Promise((resolve, reject) => {
    const status = 3
    environment.post('/status/change/' + status, card)
      .then((success) => {
        resolve(success.data)
        commit('EDIT_CARDS', success.data)
        location.reload()
        Loading.hide()
      })
      .catch((error) => {
        reject(error)
        Loading.hide()
      })
  })
}

export {
  getCards,
  blockCards,
  activeCards,
  approvedCards,
  disapprovedCards
}

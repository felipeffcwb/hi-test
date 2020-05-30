const GET_CARDS = (state, payload) => {
  state.cards = payload
}

const EDIT_CARDS = (state, payload) => {
  debugger
  for (let i = 0; i < state.cards.length; i++) {
    state.cards[i] = payload
    break
  }
}

export {
  GET_CARDS,
  EDIT_CARDS
}

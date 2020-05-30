const cards = (state) => {
  debugger
  return state.cards.filter(card => card.id).lenght
}

export {
  cards
}

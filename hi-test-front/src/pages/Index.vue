<template>
  <q-page class="container">
    <div class="empty"></div>
    <div class="row justify-center q-px-sm">
      <div class="col-xs-12 col-sm-6 col-md-6" v-for="(card, index) in cards" :key="index">
        <q-card class="my-card flex column justify-between flip-diagonal-2-br">
          <div class="fit primary">
            <q-card-section class="q-pa-none bg-dark" v-if="card.statusAction == 'BLOCK'">
              <div class="flex content-center q-pl-sm text-white" style="min-height:30px;">
                {{card.statusAction}}
              </div>
            </q-card-section>
            <q-card-section class="q-pa-none bg-positive" v-if="card.statusAction == 'ACTIVE'">
              <div class="flex content-center q-pl-sm text-white" style="min-height:30px;">
                {{card.statusAction}}
              </div>
            </q-card-section>
            <q-card-section class="q-pa-none bg-primary" v-if="card.statusAction == 'APPROVED'">
              <div class="flex content-center q-pl-sm text-white" style="min-height:30px;">
                {{card.statusAction}}
              </div>
            </q-card-section>
            <q-card-section class="q-pa-none bg-negative" v-if="card.statusAction == 'DISAPPROVED'">
              <div class="flex content-center q-pl-sm text-white" style="min-height:30px;">
                {{card.statusAction}}
              </div>
            </q-card-section>
            <q-card-section>
              <div class="text-h6">{{card.name}}</div>
              <div class="text-subtitle2">{{card.title}}</div>
            </q-card-section>
            <q-card-section>
                {{card.text}}
            </q-card-section>
          </div>
          <q-card-actions align="right">
            <q-btn flat round color="black" icon="block" v-on:click="block(card)" />
            <q-btn flat round color="green" icon="check" v-on:click="active(card)" />
            <q-btn flat round color="blue" icon="thumb_up_alt" v-on:click="approved(card)" />
            <q-btn flat round color="red" icon="thumb_down_alt" v-on:click="disapproved(card)" />
            <q-btn flat round color="yellow" icon="hourglass_full" />
          </q-card-actions>
        </q-card>
      </div>
    </div>
    <div class="empty"></div>
  </q-page>
</template>

<script>
import { mapActions, mapState } from 'vuex'
export default {
  name: 'PageIndex',
  mounted () {
    this.getCards()
  },
  computed: {
    ...mapState('Cards', ['cards'])
  },
  methods: {
    ...mapActions('Cards', ['getCards']),
    ...mapActions('Cards', ['blockCards']),
    ...mapActions('Cards', ['activeCards']),
    ...mapActions('Cards', ['approvedCards']),
    ...mapActions('Cards', ['disapprovedCards']),

    block (card) {
      this.blockCards(card)
    },
    active (card) {
      this.activeCards(card)
    },
    approved (card) {
      this.approvedCards(card)
    },
    disapproved (card) {
      this.disapprovedCards(card)
    }
  }
}
</script>

<style scoped>
  @import "../css/index.scss";
</style>

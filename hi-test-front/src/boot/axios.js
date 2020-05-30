import axios from 'axios'

const environment = axios.create({
  baseURL: process.env.API
})

export { environment }

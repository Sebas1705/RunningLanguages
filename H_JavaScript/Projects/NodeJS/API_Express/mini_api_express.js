const express = require('express')
const ditto = require('./src/pokemons/ditto.json')

const app = express()

const PORT = process.env.PORT ?? 8080

//Middleware [JSON organizer]:
// app.use((req, res, next) =>{
//     if(req.method!=='POST') return next()
//     if(req.headers['content-type']!=='application/json') return next()
//     let body=''
//     req.on('data',chunk=>{
//         body += chunk.toString()
//     })
//     req.on('end',()=>{
//         let data=JSON.parse(body)
//         data.timestamp=Date.now()
//         req.body=data
//         next()
//     })
// })
//Same that:
app.use(express.json())

//Same as Node:
app.disable('x-powered-by')

app.get('/', (req, res) => {
    //res.send('<h1>Mi pagina</h1>')
    res.json('hola mundo')
})

app.get('/pokemon/ditto', (req, res) => {
    res.json(ditto)
})

app.post('/pokemon', (req, res) => {
    res.status(201).json(req.body)
})

app.use((req,res)=>{
    res.status(404).send('<h1>404 Not Found</h1>')
})

app.listen(PORT,()=>{
    console.log(`listening on port http://localhost:${PORT}`)
})
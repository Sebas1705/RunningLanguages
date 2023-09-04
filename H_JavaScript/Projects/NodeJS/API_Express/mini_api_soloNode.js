const http = require('node:http');
const config = require('./config.json')
const desiredPort = config.port

const ditto=require('./src/pokemons/ditto.json');

const server = http.createServer(async (req,res)=>{
    const {method, url} = req
    switch (method){
        case 'GET':
            res.setHeader('Content-Type', 'text/html; charset=utf-8')
            switch(url){
                case '/':
                    res.end('<h1>Mini-Api</h1>')
                case '/pokemon/ditto':
                    res.setHeader('Content-Type', 'application/json; charset=utf-8')
                    res.end(JSON.stringify(ditto))
            }
            break
        case 'POST':
            case '/pokemon':
                let body=''
                req.on('data',chunk=>{
                    body += chunk.toString()
                })
                req.on('end',()=>{
                    let data=JSON.parse(body)
                    res.writeHead(201,{'Content-Type': 'application/json; charset=utf-8'})
                    data.timestamp=Date.now()
                    res.end(JSON.stringify(data))
                })
                break
            default:
                res.statusCode = 404
                res.setHeader('Content-Type', 'text/html; charset=utf-8')
                res.end("<h1>404 Not Found</h1>")
    }
})

server.listen(desiredPort,()=>{
    console.log(`server listening on port http://localhost:${desiredPort}`)
})

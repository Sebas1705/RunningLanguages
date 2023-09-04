const http = require('node:http')
const config = require('./config.json')
const fs = require('node:fs')

const desiredPort = config.port

const server = http.createServer(async (req,res) =>{
    console.log('request received: '+req.url)
    res.setHeader('Content-Type', 'text/plain; charset=utf-8')
    switch(req.url){
        case '/':
            res.end('<h1>Hola mundo</h1>')
            break
        case '/admin':
            res.end('<h1>Buenas Admin</h1>')
            break
        case '/apple.png':
            fs.readFile('./src/img/apple.png',(err,data) =>{
                if(err){
                    res.statusCode=500
                    res.end('<h1>500 Internal Server Error</h1>')
                }else{
                    res.setHeader('Content-Type', 'image/png')
                    res.end(data)
                }
            })
            break
        default:
            res.statusCode=404
            res.end('<h1>Pages not found (404)</h1>')
    }
})

server.listen(desiredPort,() =>{
    console.log('listening on port '+desiredPort)
})
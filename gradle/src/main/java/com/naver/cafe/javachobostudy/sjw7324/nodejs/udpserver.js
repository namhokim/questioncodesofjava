const dgram = require('dgram');
const server = dgram.createSocket('udp4');

server.on('error', (err) = > {
    console.log(`server error:\n${err.stack}`);
server.close();
})
;

server.on('message', (msg, remote) = > {
    console.log(`server got: ${msg} from ${remote.address}:${remote.port}`);
server.send(new Buffer(msg), remote.port, remote.address, function (err, bytes) {
    if (err) throw err;
    console.log(`UDP message sent to ${remote.address}:${remote.port}`);
});
})
;

server.on('listening', () = > {
    const address = server.address();
console.log(`server listening ${address.address}:${address.port}`);
})
;

server.bind(9876);
// server listening 0.0.0.0:9876
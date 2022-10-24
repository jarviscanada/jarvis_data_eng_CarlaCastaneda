const express = require('express')
const bodyParser = require("body-parser");

const app = express();
const tweetController= require('./controllers/tweets');
const cors = require('cors');
app.use(cors());
app.use(bodyParser.json());

app.use(bodyParser.urlencoded({extended:false}));
app.use(function(req,res,next){
    express.json();
    console.log("json parser");
    next();
});


// app.use(cors());
app.use((req,res, next)=>{
    console.log('This is the request object:', req);
    console.log(`${req.method} at path ${req.path}`);
    next();
});

app.use('/tweets',tweetController);

app.use('/',(req,res)=>{
    res.send("welcome to twitterbackend!")
})

app.listen(4000,()=>{
    console.log('App is listening on port 4000');
});

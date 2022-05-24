const express = require ('express');
const sendMail = require ('./mail');
const log = console.log;
const app = express();
const path = require ('path');
const PORT = 3238;
//data parsing(parseo de datos)
app.use(express.urlencoded({extended:false}));
app.use(express.json());
//send email here
app.post('/email',(req,res)=>{
const{subject,email,text} = req.body;
console.log('data:',req.body);
sendMail(email,subject,text,function(err,data){
    if(err){
        res.status(500).json({
            message:'internal error'
        });
    }else{
        res.json({
            message: 'email send'
        });
    }
});
});
//líneas necesarias para poder aplicar el css, decirle que use la carpeta views como estática
app.use(express.static("views"));
//dar como respuesta el archivo index
app.get('/',(req,res)=>{res.sendFile('index.html');})
//si se escuchó bien que me diga donde se inició el puerto
app.listen(PORT,()=> log('Server is starting on PORT,',3238));
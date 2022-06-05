const express = require ('express');
const log = console.log;
const app = express();
const PORT = process.env.PORT ||  3238;
//data parsing(parseo de datos)
app.use(express.static('views'));
app.use(express.json());
//send email here
app.get('/',(req,res) =>{
    res.sendFile(__dirname + "/views/index.html")
})
app.post('/',(req,res) =>{
    console.log(req.body);

    const transporter = nodemailer.createTransport({
        service: "gmail",
        auth: {
            user: "closetproject2022@gmail.com",
            pass: "closet2022"
        }
    })

    const mailOptions = {
        from: req.body.email,
        to: "closetproject2022@gmail.com",
        subject: 'message From ${req.body.email}: ${req.body.subject}',
        text: req.body.message
    }

    transporter.sendMail(mailOptions,(error,info)=>{
        if(error){
            console.log(error);
            res.send('error');
        }else{
            console.log('email');
            res.send('sucess');
        }
    })
})
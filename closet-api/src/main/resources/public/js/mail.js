const nodemailer = require ('nodemailer');
const mailGun = require ('nodemailer-mailgun-transport');
const auth = {
        auth:{
            api_key:'key-fc3f4bf04c8feddf55c11f10314c373f',
            domain:'sandbox2a810e57245346d3b5579788356697fc.mailgun.org'
        }
};

const transporter = nodemailer.createTransport(mailGun(auth));
const sendMail = (email,subject,text,cb)=>{
    const mailOptions = {
        from: email,
        to: 'closetproject2022@gmail.com',
        subject,
        text
    };

    transporter.sendMail(mailOptions,function(err,data){
        if(err){
            cb(err,null);
        }else{
            cb(null,data);
        }
    });
}

module.exports = sendMail;
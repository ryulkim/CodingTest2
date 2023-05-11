const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[]
let h
let m

r1.on("line",(line)=>{
    input=line.split(' ').map(e1=>parseInt(e1));
    h=input[0];
    m=input[1];
    r1.close();
})


r1.on('close',()=>{

    if(m>=45){
        m-=45;
    }
    else{
        if(h>0){
            h-=1;
            m+=15;
        }
        else{
            h=23;
            m+=15;
        }
    }
    

    console.log(h,m);
    process.exit();
}) 

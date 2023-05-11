const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[]
let h
let m
let time

r1.on("line",(line)=>{
    input.push(line.split(' ').map(e1=>parseInt(e1)));
    
    //r1.close();
})


r1.on('close',()=>{
    //console.log(input)

    h=input[0][0];
    m=input[0][1];
    time=input[1][0];

    m+=time;

    if(m>=60){
        h+=parseInt(m/60);
        if(h>23){
            h-=24;
        }
        m%=60;
    }

    console.log(h,m);
    process.exit();
}) 

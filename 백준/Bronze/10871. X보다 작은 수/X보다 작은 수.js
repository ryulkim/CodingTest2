const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[];
let n;
let x;

r1.on("line",(line)=>{
    input.push(line.split(' ').map(e1=>parseInt(e1)));
    
    //r1.close();
})


r1.on('close',()=>{
    n=input[0][0];
    x=input[0][1];

    let arr=[];

    for(let i=0;i<n;i++){
        if(input[1][i]<x){
            arr.push(input[1][i]);
            //process.stdout.write(input[1][i]);
        }
    }

    arr.map((er)=>process.stdout.write(er+" "));
    
    process.exit();
}) 

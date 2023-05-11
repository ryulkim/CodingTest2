const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[];
let x;
let n;
let a;
let b;
let total=0;

r1.on("line",(line)=>{
    input.push(line.split(' ').map(e1=>parseInt(e1)));
    
    //r1.close();
})


r1.on('close',()=>{
    x=input[0][0];
    n=input[1][0];
    
    for(let i=2;i<2+n;i++){
        a=input[i][0];
        b=input[i][1];
        total+=(a*b);
    }

    if(total==x){
        console.log("Yes");
    }
    else{
        console.log("No");
    }

    process.exit();
}) 

const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[];
let n;
let x;

r1.on("line",(line)=>{
    //input.push(line.split(' ').map(e1=>parseInt(e1)));
    input.push(line.split(' '));
    //r1.close();
})


r1.on('close',()=>{
    s=input[0][0];
    x=parseInt(input[1][0]);

    let arr=[];

    console.log(s[x-1]);
    //arr.map((er)=>process.stdout.write(er+" "));
    
    process.exit();
}) 

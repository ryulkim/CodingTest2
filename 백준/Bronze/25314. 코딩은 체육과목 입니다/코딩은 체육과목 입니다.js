const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[];
let n;
let total=0;

r1.on("line",(line)=>{
    input.push(line.split(' ').map(e1=>parseInt(e1)));
    
    //r1.close();
})


r1.on('close',()=>{
    n=input[0][0];
    
    for(let i=0;i<n/4;i++){
        process.stdout.write("long ");        
    }

    process.stdout.write("int");

    process.exit();
}) 

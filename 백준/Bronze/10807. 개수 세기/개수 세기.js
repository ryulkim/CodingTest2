const readline=require("readline");

const r1=readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let input=[];
let n;
let v;

r1.on("line",(line)=>{
    input.push(line.split(' ').map(e1=>parseInt(e1)));
    
    //r1.close();
})


r1.on('close',()=>{
    n=input[0][0];
    let x=input[2][0];
    let count=0;

    for(let i=0;i<n;i++){
        if(input[1][i]==x){
            count++;
        }
    }

    console.log(count);

    process.exit();
}) 

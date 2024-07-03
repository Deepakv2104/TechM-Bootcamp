function count(n){
    let c=0;
    while(n!=0){
        c++;
        n=Math.floor(n/10);
    }
    return c;
}
function findNum(n,c){
    let res=0;
    while(n!=0){
        let rem=n%10;
        res=res+Math.pow(rem,c);
        n=Math.floor(n/10);
    }
    return res;
}
var n=parseInt(prompt("Enter the Number"));
var c=count(n);
var result=findNum(n,c);
if(n==result){
    document.write(n + " is Armstrong Number");
}else{
    document.write(n + " is not an Armstrong Number");
}


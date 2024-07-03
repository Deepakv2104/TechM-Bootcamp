var names=new String();
var n=parseInt(prompt("Enter the Number of Strings"));
for(let i=0;i<n;i++){
    names[i]=prompt("Enter the String");
}
document.write("Reversed String is ");
for(let i=n-1;i>=0;i--){
    document.write(names[i] + " ");
}
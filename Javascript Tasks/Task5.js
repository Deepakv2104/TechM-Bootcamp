var arr=[40,39,44,8,16,10,33];
var small=arr[0],large=arr[0];
for(let i=1;i<arr.length;i++){
    small=Math.min(arr[i],small);
    large=Math.max(arr[i],large);
}
console.log("Smaller Number is " + small);
console.log("Largest Number is " + large);
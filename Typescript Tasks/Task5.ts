var numbers:number[]=[39,40,44];
console.log(numbers);

numbers.push(100);
console.log("Array after adding element at last " + numbers);

numbers.unshift(8);
console.log("Array after adding element at first " + numbers);


numbers.pop();
console.log("Array after removing element at last " + numbers);

numbers.shift();
console.log("Array after removing element at first " + numbers);

console.log("Traversing Array Elements through for of loop");
for(let num of numbers){
    console.log(num);  
}

console.log("Traversing Array Elements through for in loop");
for(let num in numbers){
    console.log(numbers[num]);  
}
var numbers = [39, 40, 44];
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
for (var _i = 0, numbers_1 = numbers; _i < numbers_1.length; _i++) {
    var num = numbers_1[_i];
    console.log(num);
}
console.log("Traversing Array Elements through for in loop");
for (var num in numbers) {
    console.log(numbers[num]);
}

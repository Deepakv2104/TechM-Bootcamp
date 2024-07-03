function combine(flag, num) {
    return flag ? num : flag;
}
console.log(combine(true, 240));
console.log(combine(false, 40));

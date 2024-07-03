var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["White"] = 2] = "White";
    Color[Color["Blue"] = 3] = "Blue";
})(Color || (Color = {}));
var selectedColor = Color.Red;
console.log("Selected Color: " + selectedColor);
console.log("Selected Color Name: " + Color[selectedColor]);

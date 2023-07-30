<?php      
// app/Calculator.php

namespace app; 

class Calculator
{
    public function add($number1, $number2) {
        return $number1 + $number2;
    }

    public function subtract($number1, $number2) {
        return $number1 - $number2;
    }

    public function multiply($number1, $number2) {
        return $number1 * $number2;
    }
    public function divide($number1, $number2) {
        if ($number2 == 0) {
            throw new \InvalidArgumentException("Division by zero is not allowed.");
        }
        return $number1 / $number2;
    }
}
?>

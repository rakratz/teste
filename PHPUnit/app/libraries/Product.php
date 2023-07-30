<?php 
namespace app\libraries;
class Product {
    private $name;
    private $price;
    private $quantity;

    public function getName() {
        return $this->name;
    }
    public function setName($name) {
        $this->name = $name;
    }  
    public function getPrice() {
        return $this->price;
    } 
    public function setPrice($price) {
        $this->price = $price;
    }
    public function getQuantity() {
        return $this->quantity;
    }
    public function setQuantity($quantity) {
        $this->quantity = $quantity;
    }
    public function getTotalPrice() {
        return $this->price * $this->quantity;
    }
}

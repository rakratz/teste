<?php 
namespace tests;

use app\libraries\Cart;
use app\libraries\Product;
use PHPUnit\Framework\TestCase;

Class CartTest extends TestCase {

    //testAlgumaCoisa
    //test_alguma_coisa
    public function test_if_cart_is_empty(){
        $cart = new Cart;

        $this->assertEmpty($cart->getCart());

    }

    public function test_if_cart_is_not_empty(){
        $cart = new Cart;

        
        $product = new Product;
        $product->setName("Coca-cola");
        $cart->add($product);
        
        $this->assertNotEmpty($cart->getCart());
    }
}

?>
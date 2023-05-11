<?php
$list_donation = [
    ["id" =>1, "donation_title" => "Beli PC baru", "receiver_name" => "Vincent", "description" =>  "Donasi ini dilakukan untuk membantu salah satu teman kita untuk mengumpulkan dana untuk membeli PC baru demi kebutuhan kuliahnya", "img_url" => "https://w0.peakpx.com/wallpaper/144/852/HD-wallpaper-pc-gamer-1-game-pc-gamer.jpg", "donation_needed" => 15000000, "donation_received" => 8500000, "total_contributor" => 6],
    ["id" =>2, "donation_title" => "Liburan ke Malang", "receiver_name" => "Gede","description" =>  "Donasi ini dilakukan untuk membantu salah satu teman kita untuk mengumpulkan dana untuk berlibur ke Malang agar bisa healing", "img_url" => "https://1.bp.blogspot.com/-HaVIErkBMqA/XfhoUb2cCLI/AAAAAAAAcB8/tugpKF5XreU0vGpmdwR2CbyicXA5QpSDwCLcBGAsYHQ/s1600/alun%2Balun%2Bkota%2Bmalang%2Bby%2Big%2Bfatmaagust.92.jpg","donation_needed" => 2000000, "donation_received" => 300000, "total_contributor" => 5],
    ["id" =>3, "donation_title" => "Hidup Mewah", "receiver_name" => "Dastyn", "description" =>  "Donasi ini dilakukan untuk membantu salah satu teman kita untuk mengumpulkan dana untuk meningkatkan gaya hidupnya yang sekarang agar tidak stress", "img_url" => "https://c4.wallpaperflare.com/wallpaper/410/766/561/car-estate-blue-car-sports-car-wallpaper-preview.jpg", "donation_needed" => 10000000, "donation_received" => 100000, "total_contributor" => 1],
    ["id" =>4, "donation_title" => "Beli HP baru", "receiver_name" => "Ryan", "description" =>  "Donasi ini dilakukan untuk membantu salah satu teman kita untuk mengumpulkan dana agar bisa membeli hp baru yang tidak lemot dan baterainya cepat habis", "img_url" => "https://fdn2.gsmarena.com/vv/pics/apple/apple-iphone-14-pro-max-1.jpg", "donation_needed" => 5500000, "donation_received" => 4000000, "total_contributor" => 4],
    ["id" =>5, "donation_title" => "Bayar sewa kos", "receiver_name" => "Kenny", "description" =>  "Donasi ini dilakukan untuk membantu teman kita untuk mengumpulkan dana untuk membayar biaya sewa kos bulanan", "img_url" => "https://c4.wallpaperflare.com/wallpaper/1011/101/300/apartment-condo-design-home-wallpaper-preview.jpg", "donation_needed" => 1500000, "donation_received" => 1485000, "total_contributor" => 3]
    ];

if (isset($_GET['id']) && is_numeric($_GET['id'])){
    $selectedId = $_GET['id'];
    $donation_detail = null;
    for($i=0; $i < count($list_donation); $i++)
    {
        if($list_donation[$i]['id'] == $selectedId){
            $donation_detail = $list_donation[$i];
            break;
        }
    }
    echo json_encode($donation_detail);
}
else{
    echo json_encode($list_donation);
}

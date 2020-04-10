<?php
	$dbhost = "localhost";
	$dbuser = "root";
	$dbpass = "";
	$dbname = "kuliah_sab";
$conn = mysqli_connect($dbhost,$dbuser,$dbpass,$dbname) or die('Gagal Konek');

if($_SERVER['REQUEST_METHOD']== 'POST') {
	$nrp = $_POST['Nrp'];
	$nama = $_POST['Nama'];
	$jurusan = $_POST['Jurusan'];
	
$sql = "INSERT INTO mahasiswa VALUES('".$nrp."','".$nama."','".$jurusan."')";
$result = mysqli_query($conn, $sql);

if($result) {
    echo "success";
}else {
     echo "failure";
}
mysqli_close($conn);
}

?>
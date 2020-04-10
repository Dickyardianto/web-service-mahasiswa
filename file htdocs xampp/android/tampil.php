<?php
	$dbhost = "localhost";
	$dbuser = "root";
	$dbpass = "";
	$dbname = "kuliah_sab";
	$conn = mysqli_connect($dbhost,$dbuser,$dbpass,$dbname);
	$response = array();

	$sqltampil = "SELECT * FROM mahasiswa";
	$result = mysqli_query($conn, $sqltampil);

if(mysqli_num_rows($result) > 0) {
	$response["mahasiswa"] = array();
	while($row = mysqli_fetch_array($result)) {
		$datafield = array();
		$datafield["Nrp"] = $row["nrp"];
		$datafield["Nama"] = $row["nama"];
		$datafield["Jurusan"] = $row["jurusan"];

		array_push($response["mahasiswa"], $datafield);
	}
	$response["success"] = 1;
	echo json_encode($response);
}else {
	$response["success"] = 0;
	echo json_encode($response);
}
mysqli_close($conn);

?>
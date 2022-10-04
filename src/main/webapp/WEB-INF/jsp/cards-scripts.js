function nameF(){
    var x = document.getElementById("mySelect").value;
    console.log(x)
    location.href="/cards/all_by_doctor?doctorId=" + x
}

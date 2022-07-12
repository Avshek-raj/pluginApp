document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady(){
    sessionStorage.removeItem('user-desc');
    showData();
}

function showData(){
    cordova.plugins.sqlite.getData([], function success(result){
        const list = document.getElementById('users-div');
        result.forEach((employee, idx) => {
            list.innerHTML += `<ul class="user">${idx+ 1}.${employee.EmployeeName}</ul>`
        });
        document.querySelectorAll('.user').forEach((u, idx)=>{
            u.addEventListener('click', ()=>{
                var employeeId = idx;
                sessionStorage.setItem('employee-desc', employeeId);
                location.href = 'index.html';
        });
        });
        
    }, function error(error){
        alert('No Employees');
    })

}

document.addEventListener('backbutton', (e)=>{
    e.preventDefault();
    sessionStorage.removeItem('employee-desc');
    location.href = 'index.html';
});
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// Wait for the deviceready event before using any of Cordova's device APIs.
// See https://cordova.apache.org/docs/en/latest/cordova/events/events.html#deviceready
document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady() {
    var  listId = sessionStorage.getItem('employee-desc');

    if(listId){
        document.getElementById('submit-btn').innerText = 'Update';
        document.querySelector('#page-head').innerText = 'Update Employee';
        showData(listId);
    } 

    document.getElementById('submit-btn').addEventListener('click', function(){
        if(listId){
            updateData();
            
        }else{
            insertdata();
        }
    });

    document.getElementById('employees-btn').addEventListener('click', function(){
        location.href = 'users.html';
    });

    
}

function showData(listId){
    cordova.plugins.sqlite.getData([], function success(result){
        document.querySelector('#id').value = result[listId].Id;
        const id =document.querySelector('#id').value;
        document.querySelector('#name').value = result[listId].EmployeeName;
        document.querySelector('#salary').value = result[listId].Salary;
        document.querySelector('#address').value = result[listId].Address;
        document.querySelector('#contact').value = result[listId].Contact;
        document.querySelector('#post').value = result[listId].Post;

        document.getElementById('remove-btn').addEventListener('click', function(){
            cordova.plugins.sqlite.delete([id], function(success){
                location.href = 'users.html';
            }, function (error){
                alert(error);
            })
        });
    }, function error(error){
        alert(error);
    });
}

function updateData(){
    var id = document.querySelector('#id').value;
    var name = document.querySelector('#name').value;
    var salary = document.querySelector('#salary').value;
    var address = document.querySelector('#address').value;
    var contact = document.querySelector('#contact').value;
    var post = document.querySelector('#post').value;
    cordova.plugins.sqlite.update([id, name, salary, address, contact , post],function (success){
        alert('Updated Successfully');
        setTimeout(function(){
            location.href = "users.html"
        });
        
        
    }, function (error){
        alert(error);
    });
}

function insertdata(){
    var id = document.querySelector('#id').value;
    var name = document.querySelector('#name').value;
    var salary = document.querySelector('#salary').value;
    var address = document.querySelector('#address').value;
    var contact = document.querySelector('#contact').value;
    var post = document.querySelector('#post').value;

    cordova.plugins.sqlite.insert([id, name, salary, address, contact , post],function (success){
        alert('Employee Addded');
        setTimeout(function(){
            location.href = "users.html"
        });
    }, function (error) {
        alert("Data insertion error, Error: " + error);
    });

}

document.addEventListener('backbutton', (e)=>{
    e.preventDefault();
    location.href = 'users.html';
});
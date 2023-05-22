import React, { useState, useEffect, Paper } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { makeStyles } from '@mui/material';


export default function Student() {
  const paperStyle = {padding:'50px 20px', width:600, margin:"20px auto"}
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[students,setStudents]=useState([])
    const classes = useStyles();
    const handleClick=(e)=>{
        e.preventDefault()
        const student={name,address}
        console.log(student)
        fetch("http://localhost:8080/student/add",
          {
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(student)
          }).then(()=>{
            console.log("new student add")
          })
    }
    useEffect(()=>{
        fetch("http:8080/student/getAll")
        .then(res=>res.json())
        .then((result)=>{
            setStudents(result);
        },(error)=>{
          console.log(error);
        } )
    },[] )
  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1,  },
      }}
      noValidate
      autoComplete="off"
    >
        <h1 style={{color:"blue"}}><u>Add Student</u></h1>
      <TextField id="outlined-basic" label="Student name" variant="outlined" fullWidth
      value={name}
      onChange={(e)=>setName(e.target.value)}/>     
      <TextField id="outlined-basic" label="Student adress" variant="outlined" fullWidth
      value={address}
      onChange={(e)=>setAddress(e.target.value)}/>
      {name} {' '}
      {address}
      <br/>
      <Button variant="contained" color="secondary"
      onClick={handleClick}
      >Contained</Button> 
        {students.map(student=>(
            <Paper elevation={6} style={{margin:"10px", padding:"15px"}} key={student.id}>
                Id:{student.id}
                name:{student.name}
                address:{student.address}
      </Paper>
        ))
}
    </Box>
  );
}

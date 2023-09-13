import React from 'react';
import { useState, useEffect, useRef } from 'react';
import List from './components/List';
import './App.css';
import Form from './components/Form';
import { Sub } from './types';


interface AppStates{
  subs: Array<Sub>
  newSubsNumber: number
}

const INITIAL_STATE: Array<Sub> = [
  {
    nick: "Dapelu",
    subMonths: 3,
    avatar: 'https://i.pravatar.cc/200?u=Dapelu',
    description: 'Dapelu do as moderator sometimes'
  },
  {
    nick: "Sergie",
    subMonths: 5,
    avatar: 'https://i.pravatar.cc/200?u=Sergie',
    description: 'Sergie do as moderator sometimes'
  },
  {
    nick: "Messi",
    subMonths: 5,
    avatar: 'https://i.pravatar.cc/200?u=Messi',
  }
]

function App() {
  const [subs,setSubs] = useState<AppStates["subs"]>([]);
  const [newSubs,setNewSubs] = useState<AppStates["newSubsNumber"]>(0)
  const divRef = useRef<HTMLDivElement>(null)

  useEffect(()=>{
    setSubs(INITIAL_STATE);
  },[])

  const handleNewSub = (newSub: Sub) =>{
    setSubs(subs => [...subs,newSub])
  }

  return (
    <div className="App" ref={divRef}>
      <h1>Subs</h1>
      <Form onNewSub={handleNewSub}/>
      <List subs={subs}>
        hola
      </List>
    </div>
  );
}

export default App;

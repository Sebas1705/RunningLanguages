import { useState } from 'react'
import { TURNS } from './logic/constants.js'
import { checkWinner, checkEndGame } from './logic/board.js'
import { WinnerModal } from './components/WinnerModal.jsx'
import { Board } from './components/Board.jsx'
import { Turns } from './components/Turns.jsx'
import { InfoCount } from './components/InfoCount.jsx'
import confetti from 'canvas-confetti'
import './App.css'


function App() {
  const [ board,setBoard ] = useState(Array(9).fill(null))
  const [ turn, setTurn ] = useState(TURNS.X)
  const [ winner, setWinner ] = useState(null) //null not winner, false tie 
  const [ countX, setCountX ] = useState(0)
  const [ countO, setCountO ] = useState(0)

  const updateBoard = (index) => {
    if(board[index] || winner) return
    const newBoard = [...board]
    newBoard[index]=turn
    setBoard(newBoard) //sets asynchronous

    const newTurn = turn === TURNS.X ? TURNS.O : TURNS.X
    setTurn(newTurn)

    const newWinner = checkWinner(newBoard)
    if(newWinner) {
      confetti()
      setWinner(newWinner)
      if(newWinner===TURNS.X)setCountX(countX+1)
      else setCountO(countO+1)
    }
    else if (checkEndGame(newBoard)) setWinner(false)
    
  }

  const resetGame = () => {
    setBoard(Array(9).fill(null))
    setTurn(TURNS.X)
    setWinner(null)
  }
  const resetAll=()=>{
    setCountO(0)
    setCountX(0)
    resetGame()
  }

  return (
    <main className='board'>
      <h1>Tic tac toe</h1>
      <InfoCount x={countX} o={countO}/>
      <button onClick={resetAll}>Reset</button>
      <Board board={board} updateBoard={updateBoard}/>
      <Turns turn={turn}/>
      <WinnerModal winner={winner} resetGame={resetGame} />
    </main>
  )
}

export default App

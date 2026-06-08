import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

function App() {
  let inicial = 10;
  const [count, setCount] = useState(inicial);
  const upCount = () => {
    setCount(count + 1);
  }

  const downCount = () => {
    setCount(count - 2);
  }


  return (
    <>
      <section id="center">
        <div className="hero">
          <img src={heroImg} className="base" width="170" height="179" alt="" />
          <img src={reactLogo} className="framework" alt="React logo" />
          <img src={viteLogo} className="vite" alt="Vite logo" />
        </div>
        <div>
          <h1>Get started</h1>
          <p>
            Edit <code>src/App.jsx</code> and save to test <code>HMR</code>
          </p>
        </div>
        <button
          type="button"
          className="counter"
          onClick={upCount}
        >
          Count is {count}
        </button>

        <button
            type="button"
            className="counter"
            onClick={downCount}
        >
          Count is {count}
        </button>
      </section>

      <div className="ticks"></div>



      <div className="ticks"></div>
      <section id="spacer"></section>
    </>
  )
}

export default App

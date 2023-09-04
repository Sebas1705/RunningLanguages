import { Square } from './Square.jsx'
import { TURNS } from '../logic/constants.js'

export const Turns = ({turn}) => {
    return (
        <section className='turn'>
            <Square isSelected={turn===TURNS.X}>{TURNS.X}</Square>
            <Square isSelected={turn===TURNS.O}>{TURNS.O}</Square>
        </section>
    )
}
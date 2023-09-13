import {Sub} from '../types'

interface Props{
    children: string
    subs:Array<Sub>
}

const List : React.FC<Props> = ({subs}) =>{
    const renderList  = (): JSX.Element[]=>{
        return subs.map(sub=>{
            return (
                <li key={sub.nick}>
                    <img src={sub.avatar} alt={`Avatar for ${sub.nick}`} />
                    <h4>{sub.nick} (<small>{sub.subMonths}</small>)</h4>
                    <p>{sub.description?.substring(0,200)}</p>
                </li>
            )
        })
    }
    return (
        <ul>
            {renderList()}
        </ul>
    )
}

export default List
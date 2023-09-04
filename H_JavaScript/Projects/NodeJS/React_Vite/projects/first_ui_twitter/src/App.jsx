import './App.css'
import { TwitterFollowCard } from './TwitterFollowCard.jsx'

export function App(){
    const midudev = {isFollowing: false, userName: "midudev"}
    return (
        <section className='App'>
            <TwitterFollowCard userName='goku'>
                Goku
            </TwitterFollowCard>
            
            <TwitterFollowCard {...midudev}>
                Miguel Lugo    
            </TwitterFollowCard>
            
            <TwitterFollowCard userName='pepe' children='Jose Lopez'/>
            
            <TwitterFollowCard userName='messi'>
                <strong>Lionel Andres Messi</strong>
            </TwitterFollowCard>
        </section>     
    )
}
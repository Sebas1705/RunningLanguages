import { useState } from "react";

export function TwitterFollowCard({children, userName}){
    const [isFollowing, setIsFollowing] = useState(false)

    const imageSrc = "https://unavatar.io/${userName}"
    const text = (isFollowing)?"Siguiendo":"Seguir";
    const buttonClassName=isFollowing ? "tw-follow-card-button is-following" : "tw-follow-card-button"
    
    const handleClick=()=>{
        setIsFollowing(!isFollowing);
    }
    
    return (
        <article className='tw-follow-card'>
            <header className='tw-follow-card-header'>
                <img 
                    alt="Goku's avatar" 
                    src={imageSrc}
                    className='tw-follow-card-avatar'
                />
                <div className='tw-follow-card-info'>
                    <strong className='tw-follow-card-info-name'>{children}</strong>
                    <span className='tw-follow-card-info-tag'>@{userName}</span>
                </div>
            </header>
            <aside>
                <button className={buttonClassName} onClick={handleClick}>
                    {text}
                </button>
            </aside>
        </article>
    )
}
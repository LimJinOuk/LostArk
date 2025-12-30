import React, { useState, useEffect } from 'react';
import SsalsoongiLogo from '../assets/쌀숭이.png';
import {
    Search, X, ExternalLink, MousePointer2,
    Sun, Moon, LayoutDashboard, ShoppingBag, Trophy, Library,
    Shield, Swords, Star, Zap, BarChart3, Box, Gem, Sparkles
} from 'lucide-react';

// --- 확장된 가상 데이터 ---
const mockData = {
    name: "치킨버거사주세요",
    server: "카마인",
    job: "슬레이어",
    itemLevel: "1642.50",
    expLevel: "70",
    guild: "치킨은못참지",
    title: "운명의 부름",
    stats: [
        { label: "치명", value: "654" },
        { label: "특화", value: "1842" },
        { label: "신속", value: "52" }
    ],
    engravings: ["처단자 Lv.3", "원한 Lv.3", "예리한 둔기 Lv.3", "돌격대장 Lv.3", "아드레날린 Lv.3"],
    equipment: [
        { type: "무기", name: "+25 공허의 심판 롱소드", quality: 100, transcendence: "7단계", elixir: "공격력 Lv.5" },
        { type: "투구", name: "+23 공허의 심판 머리장식", quality: 94, transcendence: "7단계", elixir: "회피 Lv.5" },
        { type: "상의", name: "+23 공허의 심판 가슴보호구", quality: 98, transcendence: "7단계", elixir: "생명력 Lv.5" },
        { type: "하의", name: "+23 공허의 심판 하의", quality: 92, transcendence: "7단계", elixir: "방어력 Lv.5" },
    ],
    accessories: [
        { type: "목걸이", name: "찬란한 영웅의 목걸이", quality: 95, stats: "치명 / 특화" },
        { type: "귀걸이", name: "찬란한 영웅의 귀걸이", quality: 92, stats: "특화" },
        { type: "반지", name: "찬란한 영웅의 반지", quality: 100, stats: "특화" },
    ]
};

export default function MidnightModeLayout() {
    const [isDark, setIsDark] = useState(true);
    const [searchQuery, setSearchQuery] = useState('');
    const [showResult, setShowResult] = useState(false);
    const [showBottomAd, setShowBottomAd] = useState(true);

    useEffect(() => {
        document.body.style.backgroundColor = isDark ? '#0a0a0c' : '#f8f9fa';
    }, [isDark]);

    const handleSearch = () => {
        if (searchQuery === "치킨버거사주세요") setShowResult(true);
        else { alert("'치킨버거사주세요'를 입력해주세요!"); setShowResult(false); }
    };

    return (
        <div className={`min-h-screen transition-all duration-500 font-sans selection:bg-[#4c1d95]/30
            ${isDark ? 'bg-[#0a0a0c] text-[#ececec]' : 'bg-[#f8f9fa] text-[#1e1b4b]'}`}>

            {/* --- Header --- */}
            <header className={`fixed top-0 w-full z-[100] px-10 h-32 flex justify-between items-center backdrop-blur-3xl border-b transition-all
                ${isDark ? 'bg-[#0d0d10]/95 border-[#2e1065]/40 shadow-2xl' : 'bg-white/90 border-[#2e1065]/10 shadow-lg'}`}>

                <div onClick={() => setShowResult(false)} className="flex items-center gap-8 cursor-pointer group px-4 py-2 rounded-[30px] hover:bg-[#6d28d9]/5 transition-all">
                    <div className="relative">
                        <div className={`absolute -inset-4 blur-3xl rounded-full opacity-20 group-hover:opacity-60 transition-all ${isDark ? 'bg-[#6d28d9]' : 'bg-[#2e1065]'}`} />
                        <img src={SsalsoongiLogo} alt="Logo" className="relative w-28 h-28 object-contain transition-all group-hover:scale-110 group-hover:-rotate-6" />
                    </div>
                    <div className="flex flex-col -space-y-1">
                        <div className="flex items-baseline">
                            <span className="text-[64px] font-[1000] tracking-[-0.08em] leading-none">
                                <span className="text-[#6d28d9]">R</span>IO
                            </span>
                            <span className="w-3 h-3 rounded-full bg-[#6d28d9] ml-1 shadow-[0_0_10px_#6d28d9] animate-bounce" />
                        </div>
                        <span className="text-[13px] font-bold tracking-[0.4em] uppercase opacity-40 ml-1">Archive</span>
                    </div>
                </div>

                <nav className="flex items-center gap-12">
                    {[{ name: 'SIMULATOR', icon: <LayoutDashboard size={24} /> }, { name: 'MARKET', icon: <ShoppingBag size={24} /> }, { name: 'RANKING', icon: <Trophy size={24} /> }, { name: 'ARCHIVE', icon: <Library size={24} /> }].map((item) => (
                        <a key={item.name} href="#" className={`relative flex flex-col items-center gap-2 text-[14px] font-black group ${isDark ? 'text-white/40 hover:text-white' : 'text-[#94a3b8] hover:text-[#2e1065]'}`}>
                            <span className="group-hover:-translate-y-1.5 transition-transform duration-300 group-hover:text-[#6d28d9]">{item.icon}</span>
                            <span className="text-[10px] opacity-80">{item.name}</span>
                        </a>
                    ))}
                </nav>

                <div className="flex items-center gap-8">
                    <button onClick={() => setIsDark(!isDark)} className="p-4 rounded-2xl border-2 transition-all border-white/10 text-amber-400 hover:bg-white/5">
                        {isDark ? <Sun size={26} fill="currentColor" /> : <Moon size={26} fill="currentColor" />}
                    </button>
                    <button className="px-10 py-4 rounded-[22px] border-2 text-[13px] font-black tracking-[0.2em] bg-[#6d28d9] text-white">Sign In</button>
                </div>
            </header>

            {/* --- Main Content --- */}
            <main className={`relative pt-60 pb-48 px-8 mx-auto z-10 transition-all duration-700 ${showResult ? 'max-w-[1100px]' : 'max-w-[800px]'}`}>

                <section className={`w-full transition-all duration-700 ${showResult ? 'mb-12 scale-90' : 'mb-20'}`}>
                    <div className="relative group">
                        <div className={`absolute -inset-1 rounded-[24px] blur-2xl opacity-50 ${isDark ? 'bg-[#2e1065]/30' : 'bg-[#2e1065]/10'}`} />
                        <div className={`relative flex items-center border-2 rounded-[24px] p-2 ${isDark ? 'bg-[#121216] border-white/[0.08] focus-within:border-[#6d28d9]' : 'bg-white border-[#e2e8f0]'}`}>
                            <div className="flex items-center flex-grow pl-7">
                                <Search className={isDark ? 'text-white/20' : 'text-[#cbd5e1]'} size={24} />
                                <input
                                    type="text" value={searchQuery} onChange={(e) => setSearchQuery(e.target.value)}
                                    onKeyDown={(e) => e.key === 'Enter' && handleSearch()}
                                    placeholder="분석할 모험가의 닉네임을 입력하세요"
                                    className={`w-full bg-transparent border-none text-xl px-5 py-5 focus:ring-0 font-semibold ${isDark ? 'text-white' : 'text-[#1e1b4b]'}`}
                                />
                            </div>
                            <button onClick={handleSearch} className="h-16 px-12 rounded-[18px] bg-[#6d28d9] text-white font-black text-xs tracking-[0.2em] hover:brightness-110 shadow-lg transition-all">
                                SEARCH <MousePointer2 size={16} />
                            </button>
                        </div>
                    </div>
                </section>

                {showResult ? (
                    <CharacterResultContent data={mockData} isDark={isDark} />
                ) : (
                    <div className="w-full space-y-6 opacity-20 animate-pulse">
                        <div className="w-full h-14 rounded-xl border bg-current" />
                        <div className="w-full h-72 rounded-3xl border bg-current" />
                    </div>
                )}
            </main>
        </div>
    );
}

function CharacterResultContent({ data, isDark }) {
    return (
        <div className="w-full space-y-8 animate-in fade-in slide-in-from-bottom-10 duration-1000">
            {/* 프로필 섹션 */}
            <section className={`relative overflow-hidden rounded-[40px] p-10 border ${isDark ? 'bg-[#121216] border-white/5 shadow-2xl' : 'bg-white border-[#e2e8f0] shadow-xl'}`}>
                <div className="absolute top-0 right-0 w-[400px] h-[400px] bg-[#6d28d9]/10 blur-[100px] -z-10 rounded-full" />
                <div className="flex flex-col md:flex-row gap-10 items-center">
                    <div className="relative group">
                        <div className="absolute -inset-2 bg-gradient-to-br from-[#6d28d9] to-[#4c1d95] rounded-full blur-lg opacity-40" />
                        <div className={`relative w-44 h-44 rounded-full overflow-hidden border-4 ${isDark ? 'border-[#1a1a1b]' : 'border-white'} shadow-2xl bg-black/20 flex items-center justify-center`}>
                            <span className="text-white/20 italic font-black">RIO</span>
                        </div>
                        <div className="absolute -bottom-2 left-1/2 -translate-x-1/2 bg-[#6d28d9] text-white px-4 py-1 rounded-full text-[12px] font-black">Lv.{data.expLevel}</div>
                    </div>
                    <div className="flex-grow space-y-4 text-center md:text-left">
                        <div className="flex items-center justify-center md:justify-start gap-3">
                            <span className={`px-3 py-1 rounded-lg text-[10px] font-black tracking-widest ${isDark ? 'bg-white/5 text-[#a78bfa]' : 'bg-[#6d28d9]/10 text-[#2e1065]'}`}>@{data.server}</span>
                            <span className="text-[#6d28d9] font-bold text-[14px]">{data.title}</span>
                        </div>
                        <h2 className="text-[42px] font-[1000] tracking-tight leading-none">{data.name}</h2>
                        <p className="text-[#6d28d9] font-bold text-[18px] opacity-80">{data.job}</p>
                        <div className="flex items-center justify-center md:justify-start gap-6 pt-2">
                            <div className="flex flex-col"><span className="text-[11px] font-bold opacity-40 uppercase">Item Level</span><span className="text-[24px] font-[900] text-[#6d28d9]">{data.itemLevel}</span></div>
                            <div className="w-[1px] h-10 bg-current opacity-10" />
                            <div className="flex flex-col"><span className="text-[11px] font-bold opacity-40 uppercase">Guild</span><span className="text-[18px] font-black opacity-80">{data.guild}</span></div>
                        </div>
                    </div>
                </div>
            </section>

            {/* --- 장비 & 악세사리 추가 영역 --- */}
            <div className="grid grid-cols-1 xl:grid-cols-3 gap-8">
                <div className="xl:col-span-2 space-y-6">
                    <h3 className="flex items-center gap-3 text-[18px] font-black uppercase tracking-widest"><Swords size={20} className="text-[#6d28d9]" /> Equipment</h3>
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                        {data.equipment.map((item, idx) => (
                            <div key={idx} className={`p-5 rounded-[24px] border ${isDark ? 'bg-[#121216] border-white/5' : 'bg-white border-[#e2e8f0]'}`}>
                                <div className="flex gap-4">
                                    <div className="w-14 h-14 rounded-xl bg-orange-500/10 flex items-center justify-center relative overflow-hidden">
                                        <Shield size={24} className="text-orange-500" />
                                        <div className="absolute bottom-0 left-0 h-1 bg-orange-500" style={{width: `${item.quality}%`}} />
                                    </div>
                                    <div className="flex-grow">
                                        <div className="flex justify-between items-start">
                                            <span className="text-[10px] font-black opacity-40">{item.type}</span>
                                            <span className="text-[10px] font-black text-orange-500">Q {item.quality}</span>
                                        </div>
                                        <h4 className="text-[14px] font-bold truncate">{item.name}</h4>
                                        <div className="flex gap-2 mt-2">
                                            <span className="px-2 py-0.5 rounded-md bg-[#6d28d9]/10 text-[#a78bfa] text-[9px] font-black">{item.transcendence}</span>
                                            <span className="px-2 py-0.5 rounded-md bg-emerald-500/10 text-emerald-500 text-[9px] font-black">{item.elixir}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>

                <div className="space-y-6">
                    <h3 className="flex items-center gap-3 text-[18px] font-black uppercase tracking-widest"><Gem size={20} className="text-[#6d28d9]" /> Accessories</h3>
                    <div className="flex flex-col gap-4">
                        {data.accessories.map((acc, idx) => (
                            <div key={idx} className={`p-4 rounded-[24px] border ${isDark ? 'bg-[#121216] border-white/5' : 'bg-white border-[#e2e8f0]'}`}>
                                <div className="flex items-center justify-between">
                                    <div className="flex items-center gap-4">
                                        <div className="w-10 h-10 rounded-lg bg-yellow-500/10 flex items-center justify-center"><Star size={16} className="text-yellow-500" /></div>
                                        <div><p className="text-[13px] font-bold">{acc.type}</p><p className="text-[11px] opacity-40">{acc.stats}</p></div>
                                    </div>
                                    <span className="text-[12px] font-black text-yellow-500">Q {acc.quality}</span>
                                </div>
                            </div>
                        ))}
                        <div className={`mt-4 p-6 rounded-[30px] border-2 border-dashed ${isDark ? 'border-[#6d28d9]/30 bg-[#6d28d9]/5' : 'border-[#6d28d9]/20 bg-purple-50'}`}>
                            <div className="flex items-center gap-4 mb-4"><Sparkles className="text-[#6d28d9]" size={20} /><span className="font-black text-[14px]">Summary</span></div>
                            <div className="grid grid-cols-2 gap-4">
                                <div className="flex flex-col"><span className="text-[9px] font-black opacity-50">ELIXIR</span><span className="text-[16px] font-black text-[#6d28d9]">40 (달인)</span></div>
                                <div className="flex flex-col"><span className="text-[9px] font-black opacity-50">TRANS.</span><span className="text-[16px] font-black text-[#6d28d9]">120단계</span></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            {/* 스탯 & 각인 영역 */}
            <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
                <div className={`p-8 rounded-[35px] border ${isDark ? 'bg-[#121216] border-white/5' : 'bg-white border-[#e2e8f0] shadow-lg'}`}>
                    <h3 className="flex items-center gap-3 text-[18px] font-black mb-6 uppercase tracking-widest"><Zap size={20} className="text-[#6d28d9]" /> 전투 특성</h3>
                    <div className="space-y-4">
                        {data.stats.map(stat => (
                            <div key={stat.label} className="flex items-center justify-between">
                                <span className="font-bold opacity-50">{stat.label}</span>
                                <div className="flex items-center gap-4 flex-grow px-8">
                                    <div className={`h-1.5 flex-grow rounded-full ${isDark ? 'bg-white/5' : 'bg-[#f1f5f9]'}`}>
                                        <div className="h-full bg-[#6d28d9] rounded-full" style={{ width: `${(parseInt(stat.value)/2000)*100}%` }} />
                                    </div>
                                </div>
                                <span className="font-black text-[16px]">{stat.value}</span>
                            </div>
                        ))}
                    </div>
                </div>
                <div className={`p-8 rounded-[35px] border ${isDark ? 'bg-[#121216] border-white/5' : 'bg-white border-[#e2e8f0] shadow-lg'}`}>
                    <h3 className="flex items-center gap-3 text-[18px] font-black mb-6 uppercase tracking-widest"><Shield size={20} className="text-[#6d28d9]" /> 장착 각인</h3>
                    <div className="flex flex-wrap gap-3">
                        {data.engravings.map(en => (
                            <div key={en} className={`px-4 py-2 rounded-xl text-[12px] font-bold border ${isDark ? 'bg-white/5 border-white/10 text-white/80' : 'bg-[#6d28d9]/5 border-[#6d28d9]/10 text-[#2e1065]'}`}>{en}</div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
}
import './App.css';
import JobPostsList from './components/JobPostsList';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CreateJobPost from './components/CreateJobPost';
import Navbar from './components/Navbar';
import EditJobPost from './components/EditJobPost';

function App() {
  return (
  <>
   <Navbar/>
   <BrowserRouter>
   <Routes>
   <Route path='/' element={<JobPostsList/>}/>
   <Route path="/create" element={<CreateJobPost />} />
   <Route path="/edit" element={<EditJobPost />} />
   </Routes>
   </BrowserRouter> 
  </>
  );
}

export default App;

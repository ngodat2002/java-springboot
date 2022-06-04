import React from 'react';
import  axios, { Axios }  from 'axios';

class App extends React.Component {
    constructor(props){
        super(props);
        this.state = {
          products: [],
          productId:'',
          userId:0,
          name:'',
          slug:'',
          description:'',
          detail:'',
          price:0.0,
          image: '',
          manufacturer:'',
          createdAt: '',
          updatedAt:'',
          status:0
        }
    }

    componentDidMount(){
      axios.get("http://localhost:8080/api/v1/products")
      .then((res) =>{
        this.setState({
          products:res.data,
          productId:'',
          userId:1,
          name:'',
          slug:'',
          description:'',
          detail:'',
          price:0.0,
          image: '',
          manufacturer:'',
          createdAt: '',
          updatedAt:'',
          status:1
        })
      })
    }
    submit(event,id){
        event.preventDefault();
        if(id===0){
          axios.post("http://localhost:8080/api/v1/products",{
            productId:this.state.productId,
            name:this.state.name,
            userId:this.state.userId,
            slug:this.state.slug,
            description:this.state.description,
            detail:this.state.detail,
            price:this.state.price,
            image:this.state.image,
            manufacturer:this.state.manufacturer,
            status:this.state.status
          })
          .then((res) =>{
            this.componentDidMount();
          })      
        }else{
          axios.put("http://localhost:8080/api/v1/products/",{
            productId:this.state.productId,
            userId:this.state.userId,
            name:this.state.name,
            slug:this.state.slug,
            description:this.state.description,
            detail:this.state.detail,
            price:this.state.price,
            image:this.state.image,
            manufacturer:this.state.manufacturer,
            status:this.state.status
          }).then((res) =>{
            this.componentDidMount();
          })
        }
    }

    delete(id){
      axios.delete(`http://localhost:8080/api/v1/products/${id}`)
      .then((res) =>{
        this.componentDidMount();
      })
    }

    edit(id){
      axios.get(`http://localhost:8080/api/v1/products/${id}`)
      .then((res) =>{
        console.log(res.data);
        this.setState({
            productId:res.data.productId,
            userId:res.data.userId,
            name:res.data.name,
            slug:res.data.slug,
            description:res.data.description,
            detail:res.data.detail,
            price:res.data.price,
            image:res.data.image,
            manufacturer:res.data.manufacturer,
            status:res.data.status
        })
      })
    }
    render() {
      return (
        <div className="container">

<div class="row">
    <form class="col s12" onSubmit={(e)=>this.submit(e,this.state.id)}>
      <div class="row">
        <div class="input-field col s2">
          <input onChange={(e)=>this.setState({productId:e.target.value})} id="code" value={this.state.productId} type="text" class="validate"/>
          <label for="code">CodeProduct</label>
        </div>
        <div class="input-field col s4">
          <input onChange={(e)=>this.setState({name:e.target.value})} id="last_name" value={this.state.name}  type="text" class="validate"/>
          <label for="last_name">Product Name</label>
        </div>
        <div class="input-field col s6">
          <input id="slug" onChange={(e)=>this.setState({slug:e.target.value})} value={this.state.slug} type="text" class="validate"/>
          <label for="slug">Slug</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s6">
          <input id="description" onChange={(e)=>this.setState({description:e.target.value})}  value={this.state.description}  type="text" class="validate"/>
          <label for="description">Description</label>
        </div>
        <div class="input-field col s6">
          <input id="img" value={this.state.image} onChange={(e)=>this.setState({image:e.target.value})}  type="text" class="validate"/>
          <label for="img">Image</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s8">
          <input id="detail" type="text" onChange={(e)=>this.setState({detail:e.target.value})} class="validate"/>
          <label for="detail">Detail</label>
        </div>
        <div class="input-field col s4">
          <input id="user" value={this.state.userId} onChange={(e)=>this.setState({userId:e.target.value})}  type="number" class="validate"/>
          <label for="user">UserCode</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s4">
          <input id="price" value={this.state.price} onChange={(e)=>this.setState({price:e.target.value})}  type="number" class="validate"/>
          <label for="price">Price</label>
        </div>
        <div class="input-field col s4">
          <input id="manufacturer" value={this.state.manufacturer} onChange={(e)=>this.setState({manufacturer:e.target.value})}  type="text" class="validate"/>
          <label for="manufacturer">Manufacturer</label>
        </div>
        <div class="input-field col s4">
          <input id="stt" value={this.state.status} onChange={(e)=>this.setState({status:e.target.value})} type="number" class="validate"/>
          <label for="stt">Status</label>
        </div>
      </div>
      <button class="btn waves-effect waves-light right" type="submit" name="action">Submit
         <i class="material-icons right">send</i>
      </button>
    </form>
  </div>
        
            <div className='row'>
              <div className='col s12'>
              <table className='responsive-table'>
        <thead>
          <tr>
              <th>#</th>
              <th>Product Name</th>
              <th>Slug</th>
              <th>Price</th>
              <th>Description</th>
              <th>Image</th>
              <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {
            this.state.products.map(product =>  
            <tr key={product.productId}>
              <td>{product.productId}</td>
              <td>{product.name}</td>
              <td>{product.slug}</td>
              <td>${product.price}</td>
              <td>{product.description}</td>
              <td><img src={product.image} style={{width:200}}></img></td>
              <td>
              <a class="waves-effect waves-light btn-small  ">Edit</a>
              <a class="waves-effect waves-light btn-small">Delete</a>
              <a class="waves-effect waves-light btn-small">Detail</a>
              </td>
            </tr>  
            )
          }
        </tbody>
      </table>
              </div>
            </div>
        </div>
      );
    }
}

export default App;

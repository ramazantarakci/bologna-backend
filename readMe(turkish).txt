bir terminal açıp docker-compose.yml ile aynı dizine gelip 
"docker-compose up demo-microservice demo-admin-microservice load-balancer-microservice" dediğimizde aynı ağda birbirini gören 3 tane container oluşacaktır.

farklı bir terminalde(docker-compose.yml ile aynı dizinde) "docker-compose scale demo-microservice=4" dersek demo-microservice imajından toplamda 4 tane olacak şekilde containerlar oluşturulup çalıştırılır. 

önceki terminale dönüp tarayıcıdan localhost adresine istek gönderirsek load balancer servisinin bizi farklı containerlara yönlendirdiğini ve container sayısının bağımsız olduğunu görebiliriz.

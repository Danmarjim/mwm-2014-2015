//
//  EVLoginController.m
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 22/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import "EVLoginController.h"

@interface EVLoginController ()

@end

@implementation EVLoginController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [self setItems];
}

-(IBAction)logIn
{
    if(self.userField.text.length > 0 && self.pwdField.text.length > 0){
        [self performSegueWithIdentifier:@"openMainController" sender:nil];
    } else {
        [self createAlertWrong];
    }
}

-(void)setItems
{
    //TITULO
    self.title = @"Bienvenido";
    
    //MODIFICAR LA UIImageView
    self.imageView.layer.cornerRadius = 10.0;
    
    //MODIFICAR EL UIButton
    self.buttonIn.layer.borderWidth = 1.5f;
    self.buttonIn.layer.cornerRadius = 25;
    self.buttonIn.clipsToBounds = YES;
    [self.buttonIn setTintColor:[UIColor customColor]];
    self.buttonIn.layer.borderColor = [[UIColor customColor]CGColor];
    [self.buttonIn setTitle:@"ACCEDER" forState:UIControlStateNormal];
}

//MODIFICA EL COMPORTAMIENTO DEL BOTON CUANDO SE PULSA Y SE DEJA DE PULSAR
-(IBAction) buttonTouchDown
{
    self.buttonIn.backgroundColor = [UIColor customColor];
    [self.buttonIn setTitleColor:[UIColor whiteColor] forState:UIControlStateHighlighted & UIControlStateSelected];
    self.buttonIn.layer.borderColor = [UIColor customColor].CGColor;
}

-(IBAction) buttonTouchUpOutside
{
    self.buttonIn.backgroundColor = [UIColor whiteColor];
    [self.buttonIn setTitleColor:[UIColor customColor] forState:UIControlStateHighlighted & UIControlStateSelected];
    self.buttonIn.layer.borderColor = [UIColor customColor].CGColor;
}

-(IBAction) buttonTouchUpInside
{
    self.buttonIn.backgroundColor = [UIColor whiteColor];
    [self.buttonIn setTitleColor:[UIColor customColor] forState:UIControlStateHighlighted & UIControlStateSelected];
    self.buttonIn.layer.borderColor = [UIColor customColor].CGColor;
}

//ALERT FALTAN CAMPOS POR RELLENAR
-(void)createAlertWrong
{
    _alertView = [[CustomIOSAlertView alloc] init];
    [_alertView setContainerView:[self createViewAlertWrong]];
    [_alertView setButtonTitles:[NSMutableArray arrayWithObjects:@"ACEPTAR", nil]];
    
    [_alertView setUseMotionEffects:true];
    [_alertView show];
}

-(UIView *)createViewAlertWrong
{
    UIView *demoView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 290, 130)];
    demoView.layer.cornerRadius = 10;
    demoView.clipsToBounds = YES;
    demoView.backgroundColor = [UIColor whiteColor];
    
    UITextView *text = [[UITextView alloc] initWithFrame:CGRectMake(0, 0, 290, 40)];
    text.backgroundColor = [UIColor customColor];
    text.textColor = [UIColor whiteColor];
    text.text = @"ATENCIÓN";
    [text setFont:[UIFont fontWithName:@"HelveticaNeue" size:20]];
    text.textAlignment = NSTextAlignmentCenter;
    [text setUserInteractionEnabled:FALSE];
    [demoView addSubview:text];
    
    UITextView *text2 = [[UITextView alloc] initWithFrame:CGRectMake(20, 60, 250, 110)];
    NSString *mystring1 = @"Existen campos sin rellenar.";
    NSString *mystring2 = @"Por favor revíselo antes de realizar de nuevo el acceso.";
    text2.text = [NSString stringWithFormat:@"%@\r%@", mystring1,mystring2];
    text2.textColor = [UIColor customColorTextAlert];
    [text2 setFont:[UIFont fontWithName:@"HelveticaNeue" size:15]];
    [text2 setUserInteractionEnabled:FALSE];
    [demoView addSubview:text2];
    
    return demoView;
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    [self.userField resignFirstResponder];
    [self.pwdField resignFirstResponder];
}

@end
